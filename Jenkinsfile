pipeline {
  agent any
    triggers {
       pollSCM('H/2 * * * *')
    }
    environment { 
       IMAGE="simple-1.0"
    }   
  stages {
     stage('restapp build'){
       steps{
	      sh 'echo Building ${BRANCH_NAME} ....'
	      sh 'sh $JENKINS_HOME/tools/hudson.tasks.Maven_MavenInstallation/M3/bin/mvn -e clean install'
       }
     }
     stage('Build Docker Image'){
       steps {
	       sh """
                docker build -t  opsmx11/restapp:${IMAGE} .
	        echo \"${IMAGE}\" > restapp.txt
               """
        }
     }
     stage('Push Image'){
        steps {
              withCredentials([usernamePassword(credentialsId: 'Docker-hub-devcredentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
              }
             // sh "sudo docker push opsmx11/restapp:${IMAGE}"
	 }
     }
  } 
}
