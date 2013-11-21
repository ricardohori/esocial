package br.com.synchro.esocial.conector.gateway.pages

import org.grails.plugins.dynamicConfig.ConfigProperty

import br.com.synchro.gui.meta.model.field.DateField
import br.com.synchro.gui.meta.model.field.IntegerField;
import br.com.synchro.gui.meta.model.field.SelectField;
import br.com.synchro.gui.meta.model.field.Separator;
import br.com.synchro.gui.meta.model.field.TextField
import br.com.synchro.gui.meta.model.page.Crud

class ConfigPage {

	def definition = {
		
		apply Crud using ConfigProperty

		fields {
			
			separatorConfigBasicas (Separator) {
				coordinate(1, 1)
				label "esocial.conector.configPage.separator.configBasicas"
			}
			
			rootDir (TextField) {
				coordinate(2, 1)
				label "esocial.conector.configPage.fields.rootDir.label"
				required true
				size 4.col
			}
			
			separatorFtp (Separator) {
				coordinate(3, 1)
				label "esocial.conector.configPage.separator.ftp"
			}
			
			ftpHost (TextField) {
				coordinate(4, 1)
				label "esocial.conector.configPage.fields.ftpHost.label"
				required true
				size 4.col
			}
			
			ftpPort (IntegerField) {
				coordinate(4, 2)
				label "esocial.conector.configPage.fields.ftpPort.label"
				required true
				size 4.col
			}
			
			separatorProxy (Separator) {
				coordinate(5, 1)
				label "esocial.conector.configPage.separator.proxy"
			}
			
			useProxy (SelectField) {
				coordinate(6, 1)
				label "esocial.conector.configPage.fields.useProxy.label"
				required true
				options(["S", "N"])
				size 4.col
			}
			
			proxyHost (TextField) {
				coordinate(7, 1)
				label "esocial.conector.configPage.fields.proxyHost.label"
				size 4.col
			}
			
			proxyPort (IntegerField) {
				coordinate(7, 2)
				label "esocial.conector.configPage.fields.proxyPort.label"
				size 4.col
			}
			
			proxyUser (TextField) {
				coordinate(8, 1)
				label "esocial.conector.configPage.fields.proxyUser.label"
				size 4.col
			}
			
			proxyPassword (TextField) {
				coordinate(8, 2)
				label "esocial.conector.configPage.fields.proxyPassword.label"
				size 4.col
			}
		}
	}
}
