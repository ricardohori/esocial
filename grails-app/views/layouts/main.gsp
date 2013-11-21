<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><g:layoutTitle /></title>
</head>
<body>
	<g:applyLayout name="syngui">
		<content tag="header-title"> <a
			href="${createLink(uri:'/')}" class="header-title"> <img
			src="${r.resource(dir: 'images/estrutura', file: 'logo-synchro-exp.png', plugin: 'grails-gui')}"
			style="border: none;">
		</a></content>
		<content tag="header-space"> </content>
		<content tag="header-content"> </content>
		<g:if test='${flash.message}'>
			<div class='login_message'>
				${flash.message}
			</div>
		</g:if>

		<g:layoutBody />
	</g:applyLayout>
</body>
</html>