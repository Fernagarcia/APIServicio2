package com.servicio2.Reconocimientos.Extra.solicitud_datos;

import java.io.IOException;

public interface ISolicitarDatosAdapter {
    Boolean solicitarDonacionesViandas(String url_api) throws IOException;

    Boolean solicitarColaboradores(String url_api);
}
