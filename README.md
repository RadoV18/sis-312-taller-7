# Taller #7: Automatización de Casos de Prueba

### Radomir Vladislavic / SIS-312

[Sitio web: AutomationExercise](https://www.automationexercise.com/)

## Historia de Usuario

- Yo, como usuario, quiero agregar productos al carrito en el sitio web de AutomationExercise para realizar la compra.

### Casos de Prueba

1. **Verificar que el usuario no puede realizar la compra de un producto con el carrito vacío.**

- **Precondiciones**:

    - Tener el servicio AutomationExercise funcionando.

- **Pasos**:

    1. Ingresar al sitio web.
    2. Hacer click en el botón "Sign Up / Login".
    3. Llenar el formulario con los datos de registro y hacer click en "Signup".
    4. Llenar el formulario con los datos del usuario y hacer click en "Create Account".
    5. Hacer click en el botón "Continue" en la página de bienvenida. 
    4. Hacer click en el botón "Cart".

- **Resultado Esperado**: En la pantalla se muestra el mensaje "Cart is empty!".

2. **Verificar que el usuario puede realizar la compra de un producto.**

- **Precondiciones**:

    - El usuario debe estar registrado en el sitio web.
    - El usuario debe haber iniciado sesión en el sitio web.

- **Pasos**:

    1. Ingresar al sitio web.
    2. En la sección "Features Items" seleccionar el producto "Men T-Shirt" y hacer click en "Add to cart"
    3. En la ventana emergente, hacer click en "View Cart".
    4. Hacer click en el botón "Proceed To Checkout".
    5. Hacer click en el botón "Place Order".
    6. Llenar el formulario con los datos de pago.

- **Resultado Esperado**: En la pantalla se muestra el mensaje "ORDER PLACED!".
