class NotificadorAnteAlertas implements AccionConfigurable {
  nuevasAlertasMeteorologicas(alertasNuevas, usuario) {
    alertasNuevas.forEach(alerta ->
        new Notificador().notificar(alerta.getMensaje())
    )
  }
}