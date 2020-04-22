pipeline {
			def remote = [:]
    			remote.name = "docker-host"
    			remote.host = "172.31.8.139"
    			remote.allowAnyHosts = true
			remote.user = ""
			remote.password = ""
	
	
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'jdk'
    }
    
    stages {
        
        stage ("build image") {
            steps {

                withCredentials([usernamePassword(credentialsId: 'docker-host', passwordVariable: 'password', usernameVariable: 'userName')]) {
	            remote.user = userName
	            remote.password = password

		    sshCommand remote: remote, command: 'cd /home/dockeradmin; docker build -t bnnair/societyapp .; docker run -d -p 8080:8080 bnnair/societyapp;'
            	}
            
        }
	}  
    
    }
}
