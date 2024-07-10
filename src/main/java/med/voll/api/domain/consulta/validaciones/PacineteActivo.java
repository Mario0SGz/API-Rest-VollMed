package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class PacineteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        if (datosAgendarConsulta.idPaciente() == null){
            return;
        }
        var pacienteActivo = pacienteRepository.findActivoById(datosAgendarConsulta.idPaciente());

        if (!pacienteActivo){
            throw new ValidationException("No se permite agendar citas con pacientes inactivos en el sistema" );
        }
    }
}
