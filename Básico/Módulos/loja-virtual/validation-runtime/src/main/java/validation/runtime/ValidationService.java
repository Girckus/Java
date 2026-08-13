package validation.runtime;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import validation.api.constraint.Email;
import validation.api.constraint.MaxLength;
import validation.api.constraint.NotBlank;
import validation.api.constraint.Positive;

public class ValidationService {

    public List<String> validar(Object objeto) {

        List<String> erros = new ArrayList<>();

        Class<?> classe = objeto.getClass();

        for (Field campo : classe.getDeclaredFields()) {

            validarNotBlank(objeto, campo, erros);

            validarEmail(objeto, campo, erros);

            validarPositive(objeto, campo, erros);

            validarMaxLength(objeto, campo, erros);
        }

        return erros;
    }

    private void validarNotBlank(Object objeto, Field campo, List<String> erros) {

        if (!campo.isAnnotationPresent(NotBlank.class)) {
            return;
        }

        Object valor = lerValor(objeto, campo);

        if (valor == null || valor.toString().isBlank()) {

            NotBlank annotation = campo.getAnnotation(NotBlank.class);

            erros.add(annotation.message());
        }
    }

    private void validarEmail(Object objeto, Field campo, List<String> erros) {

        if (!campo.isAnnotationPresent(Email.class)) {
            return;
        }

        Object valor = lerValor(objeto, campo);

        if (valor == null) {
            return;
        }

        String email = valor.toString();

        if (!email.contains("@")) {

            Email annotation = campo.getAnnotation(Email.class);

            erros.add(annotation.message());
        }
    }

    private void validarPositive(Object objeto, Field campo, List<String> erros) {

        if (!campo.isAnnotationPresent(Positive.class)) {
            return;
        }

        Object valor = lerValor(objeto, campo);

        if (valor instanceof Number numero) {

            if (numero.doubleValue() <= 0) {

                Positive annotation = campo.getAnnotation(Positive.class);

                erros.add(annotation.message());
            }
        }
    }

    private void validarMaxLength(Object objeto, Field campo, List<String> erros) {

        if (!campo.isAnnotationPresent(MaxLength.class)) {
            return;
        }

        Object valor = lerValor(objeto, campo);

        if (valor == null) {
            return;
        }

        MaxLength annotation = campo.getAnnotation(MaxLength.class);

        if (valor.toString().length() > annotation.value()) {
            erros.add(annotation.message());
        }
    }

    private Object lerValor(Object objeto, Field campo) {

        try {
            campo.setAccessible(true);

            return campo.get(objeto);

        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Não foi possível acessar o campo " + campo.getName(), e);
        }
    }

}