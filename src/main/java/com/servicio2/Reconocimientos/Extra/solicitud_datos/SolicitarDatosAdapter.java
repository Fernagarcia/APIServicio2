package com.servicio2.Reconocimientos.Extra.solicitud_datos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import com.servicio2.Reconocimientos.Extra.models.DonacionVianda;
import com.servicio2.Reconocimientos.Extra.repositories.ColaboradorRepository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Map;

public class SolicitarDatosAdapter implements ISolicitarDatosAdapter{
    private ColaboradorRepository colaboradorRepository;

    @Override
    public Boolean solicitarColaboradores(String url_api){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url_api))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() == 200) {
                Gson gsonMapper = new Gson();

                Type colaboradorListType = new TypeToken<List<Colaborador>>(){}.getType();

                List<Colaborador> colaboradores = gsonMapper.fromJson(response.body(), colaboradorListType);

                colaboradorRepository.saveAll(colaboradores);
            } else {
                System.out.println("Error: " + response.statusCode());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean solicitarDonacionesViandas(String url_api) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url_api))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() == 200) {
                Gson gsonMapper = new Gson();

                Type donacionesViandasListType = new TypeToken<List<DonacionVianda>>(){}.getType();

                List<DonacionVianda> donaciones = gsonMapper.fromJson(response.body(), donacionesViandasListType);

                actualizarCantidadViandasDonadas(colaboradorRepository, donaciones);

            } else {
                System.out.println("Error: " + response.statusCode());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void actualizarCantidadViandasDonadas(ColaboradorRepository colaboradorRepository, List<DonacionVianda> donaciones){
        Map<Long, Integer> viandasPorColaborador = new HashMap<>();

        donaciones.forEach(donacionVianda -> {
            Long colaboradorId = donacionVianda.getId_colaborador();

            viandasPorColaborador.put(colaboradorId, viandasPorColaborador.getOrDefault(colaboradorId, 0) + 1);
        });

        viandasPorColaborador.forEach((id_colaborador, cantidad) -> {
            colaboradorRepository.updateViandasColaboradorById(Math.toIntExact(id_colaborador), cantidad);
        });
    }
}
