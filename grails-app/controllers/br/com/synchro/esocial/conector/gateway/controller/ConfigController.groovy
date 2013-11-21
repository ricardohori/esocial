package br.com.synchro.esocial.conector.gateway.controller

import br.com.synchro.esocial.conector.gateway.repository.config.ConfigPropertyRepository;


import br.com.synchro.grails.gui.MessageService
import br.com.synchro.gui.message.Message.MessageSeverity
import br.com.synchro.gui.meta.PageArtefactHandler
import br.com.synchro.gui.meta.model.page.Crud
import br.com.synchro.gui.meta.repository.IMetamodelRepository
import br.com.synchro.gui.task.exception.StopExecutionException
import br.com.synchro.gui.validation.bind.internal.spring.SpringDataBinder
import org.grails.plugins.dynamicConfig.ConfigProperty

class ConfigController {

	IMetamodelRepository metaModelRepository
	def grailsApplication
	SpringDataBinder dataBinder
	ConfigPropertyRepository configPropertyRepository
	MessageService messageService

	def index() {
		def page = metaModelRepository.newMetamodelInstance(PageArtefactHandler.TYPE, "config")
		def final configProperties = [
			//Config Basicas
			rootDir: grailsApplication.config.esocial.conector.rootDir,
			//Ftp
			ftpHost: grailsApplication.config.esocial.conector.ftpHost,
			ftpUser: grailsApplication.config.esocial.conector.ftpUser,
			ftpPort: grailsApplication.config.esocial.conector.ftpPort,
			//Proxy
			useProxy: grailsApplication.config.proxy.useProxy,
			proxyHost: grailsApplication.config.proxy.proxyHost,
			proxyPort: grailsApplication.config.proxy.proxyPort,
			proxyUser: grailsApplication.config.proxy.proxyUser,
			proxyPassword: grailsApplication.config.proxy.proxyPassword
		]
		//Copia os valores do mapa para os campos da tela
		dataBinder.bind(configProperties, page)
		return [page:page]
	}

	/**
	 * Acao responsavel por parar a execucao da Task caso hajam erros no contexto.
	 * <p/>
	 * Renderiza a view "create" passando os erros do contexto.
	 */
	def stopSaveOnErrors = {
		if(ctx.errors?.hasErrors()) {
			render(view: "index", model: ctx)
			throw new StopExecutionException()
		}
	}

	def save = {
		//Recupera a instância da página
		Crud page = metaModelRepository.newMetamodelInstance(PageArtefactHandler.TYPE, "config")
		//Popula a página com as informações da request
		dataBinder?.bind(params, page);
		//Valida a página
		page.validatePage << stopSaveOnErrors
		def retornoValidacao = page.validatePage.configure(controller: this).execute(page: page)
		if(retornoValidacao.errors.hasErrors()){
			return
		}
		
		/**
		 * Closure que irá atualizar a propriedade no banco baseado na chave e valor
		 */
		def atualizarPropriedade = {nome, valor ->
			//			def property = ConfigProperty.
			ConfigProperty config = configPropertyRepository.findByExample(new ConfigProperty(name: nome))
			if(!config){
				config = new ConfigProperty(name: nome)
			}
			if(valor == null){
				valor = ""
			}
			config.value = valor
			config.checksum = valor?.toString().encodeAsMD5Bytes()
			configPropertyRepository.save(config)
		}
		
		//Salva as configurações
		//Config Basicas
		atualizarPropriedade('esocial.conector.rootDir', params.rootDir)
		//Ftp
		atualizarPropriedade('esocial.conector.ftpHost', params.ftpHost)
		atualizarPropriedade('esocial.conector.ftpUser', params.ftpUser)
		atualizarPropriedade('esocial.conector.ftpPort', params.ftpPort)
		//Proxy
		atualizarPropriedade('proxy.useProxy', params.useProxy)
		atualizarPropriedade('proxy.proxyHost', params.proxyHost)
		atualizarPropriedade('proxy.proxyPort', params.useProxy)
		atualizarPropriedade('proxy.proxyUser', params.proxyUser)
		atualizarPropriedade('proxy.proxyPassword', params.proxyPassword)
		
		messageService.addMessage(text: 'esocial.conector.configPage.save.success', severity: MessageSeverity.SUCCESS)
		redirect(action: "index")
	}


}
