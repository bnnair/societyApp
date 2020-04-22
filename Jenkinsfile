pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'jdk'
    }
    
    stages {
        
        stage ("build image") {
            steps {

                withCredentials([usernamePassword(credentialsId: 'docker-host', passwordVariable: 'password', usernameVariable: 'userName')]) {
    		    sshCommand remote: userName,password, command: 'cd /home/dockeradmin; docker build -t bnnair/societyapp .; docker run -d -p 8080:8080 bnnair/societyapp;'
            	}
            
        }
	}  
    
    }
}
