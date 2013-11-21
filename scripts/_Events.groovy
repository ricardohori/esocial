eventCreateWarStart = {  warName, stagingDir ->
	File classDir = new File("${stagingDir}/WEB-INF/classes/")
	def className = 'br.com.synchro.esocial.conector.jetty.Executable'
	ant.jar(destfile:"${stagingDir}/web-libs/esocial-jetty-war-executable.jar",
		basedir: classDir.absolutePath,
		includes: "**/jetty/**"
	)
	//Remove os jar do jetty de dentro do WEB-INF/lib para nÃ£o dar conflitos se deployado em outro webserver
	File libDir = new File("${stagingDir}/WEB-INF/lib/")
	libDir.eachFileMatch( ~/^.*jetty.*\.jar/) { File jarToRemove ->
		def fileNameWithoutVersion = jarToRemove.name.substring(0, jarToRemove.name.lastIndexOf('-')) + '.jar'
		ant.move(
			file: jarToRemove.path,
			tofile: "${stagingDir}/web-libs/${fileNameWithoutVersion}"
		)
	}
	
	ant.copy(
		file: "${classDir.path}/${className.replace('.', '/')}.class",
		tofile: "${stagingDir}/${className.replace('.', '/')}.class"
	)
	
	String manifestFile = "${stagingDir}/META-INF/MANIFEST.MF"
	ant.manifest(file: manifestFile, mode: "update") {
		attribute(name: "Main-Class", value: className)
	}
	
	
}
