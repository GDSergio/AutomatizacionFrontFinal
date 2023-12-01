package actions;

import org.testng.Assert;

public class LoginActions {

    public boolean validarNombre(String nombreDesplegado, String usuario) {
        for (int i = 0; i < 10; i++) {
            if (nombreDesplegado.charAt(i) == ',') {
                String nombreEnPantalla = nombreDesplegado.substring(i + 2, nombreDesplegado.length());
                try {
                    Assert.assertEquals(nombreEnPantalla, usuario.toUpperCase());
                    return nombreEnPantalla.equals(usuario.toUpperCase());
                } catch (AssertionError ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
        return false;
    }
}
