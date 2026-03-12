Feature: Trabajo de FLUJOS

  @Login @HappyPath
  Scenario Outline: Login exitoso
    Given el usuario está en la página de inicio
    And el usuario selecciona el boton de login
    And ingresa un nombre de usuario "<username>" y contraseña "<password>"
    When el usuario selecciona el boton de logearse
    Then se realiza el logeo de manera correcta

    Examples:
      | username    | password |
      | ADEL      | 123456  |

  @RegistrarUsuario @HappyPath
  Scenario Outline: Registrar de manera existosa a un usuario con credenciales validas
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de registro
    And ingresa un nombre de usuario "<username>" y contraseña "<password>" blaz
    When selecciona el boton registrar
    Then se realiza el registro de manera exitosa

    Examples:
      | username    | password |
      | Usuarioprueba2 | pass123  |

  @Logout @HappyPath
  Scenario: Cierre de sesión exitoso
    Given el usuario está autenticado
    When selecciona Cerrar sesión
    Then la sesión se cierra