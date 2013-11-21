<html>
<head>
<title>Aplicacao Referencia</title>
<meta name="layout" content="main" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>
<body class="body">
<body>
	<div class="row">
		<div class="span12">
			<h2 id="crud_title">
				<g:message code="esocial.conector.configPage.title" />
			</h2>
		</div>
	</div>

	<g:render template="/crud/errors" plugin="grails-gui"></g:render>

	<div class="body">

		<g:form action="save">

			<gui:form layout="${page.layout}"></gui:form>

			<div class="row">&nbsp;</div>

			<div class="row ly-row-spaced">
				<div class="span2">
					<button type="button" id="crud-cancel-button"
						class="btn btn-default btn-sm"
						onclick="window.location = '${createLink(controller: 'home')}';">
						<i class="icon icon-gui-cancel"></i>
						${message(code: 'synchro.gui.crud.buttons.cancel.label', default: 'Cancelar')}
					</button>
				</div>

				<div class="span6">
					<button type="submit" id="crud-save-button" name="save"
						class="btn btn-primary btn-sm pull-right">
						<i class="icon icon-gui-save"></i>
						${message(code: 'synchro.gui.crud.buttons.save.label', default: 'Salvar')}
					</button>
				</div>
			</div>
		</g:form>
		
	</div>
</body>
</html>