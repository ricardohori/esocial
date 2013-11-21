package br.com.synchro.esocial.conector.camel;

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.file.FileEndpoint
import org.apache.camel.component.file.remote.FtpEndpoint
import org.codehaus.groovy.grails.commons.GrailsApplication;


class ConectorRoute extends RouteBuilder {
	
	GrailsApplication grailsApplication

	@Override
	public void configure() throws Exception {
//		def readFromPath = grailsApplication.config.esocial.path?: '.'
//		
//		println "Configurando Rota para ler: ${readFromPath}"
//		/**
//		 * Rota para ler do diretório de entrada e colocar no FTP do eSocial Manager 
//		 */
//		//Configura o endpoint de entrada, o FileSystem
//		FileEndpoint endPointFileSystem = endpoint("file://${readFromPath}")
//		
//		//Configura o endpoint de saída, o FTP
//		FtpEndpoint ftpEndpoint = endpoint('ftp://localhost')
//		ftpEndpoint.getConfiguration().setPort(21)
//		ftpEndpoint.getConfiguration().setUsername("admin")
//		ftpEndpoint.getConfiguration().setPassword("admin")
//		ftpEndpoint.getConfiguration().setPassiveMode(true)
//		ftpEndpoint.setMove(".done")
//		ftpEndpoint.setRecursive(true)
//		
//		//Rota do Camel de fato
//		from(endPointFileSystem)
//				.to("stream:out").routeId("ROTA")
	}
}
