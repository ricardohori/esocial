package br.com.synchro.esocial.conector.gateway.repository.config



import org.grails.plugins.dynamicConfig.ConfigProperty

import br.com.synchro.esocial.conector.gateway.repository.DefaultRepositoryImpl

class ConfigPropertyRepositoryImpl extends DefaultRepositoryImpl<ConfigProperty> implements ConfigPropertyRepository  {
	
	public ConfigPropertyRepositoryImpl(){
		super(ConfigProperty.class)
	}
}
