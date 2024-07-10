package med.voll.api.domain.consulta.cancelacion;

import med.voll.api.domain.consulta.DatosCancelacionConsulta;

public interface ValidadorDeCancelacionDeConsulta {
    void validar(DatosCancelacionConsulta datosCancelacionConsulta);
}
