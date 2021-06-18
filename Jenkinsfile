def remote = [:]
remote.host = "192.168.160.87"
remote.name = "runtime"

pipeline {
    agent any

    tools{
    	    jdk 'jdk11'
    	    maven 'maven36'
    	}

    environment {
            bombeiros_image = ''
            react_image = ''
    	}


    stages {
 
        stage('Start') {
            steps{
                dir('esp11'){
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                        '''
                }
            }

        }
        stage('Build') {
            steps{
                dir('esp11'){
                    sh 'mvn -Dmaven.test.failure.ignore=true install'
                }
            }

        }

        stage('Deploy Artifact') {
            steps{
                sh 'mvn -f esp11/pom.xml -B -DskipTests clean package'
            }
        }

         stage("Publish bombeiros_image to RegistryVM"){
            steps{
                script{
                    bombeiros_image = docker.build("esp11/bombeiros_image", "./esp11")
                    docker.withRegistry("http://192.168.160.48:5000") {
                        bombeiros_image.push();
                    }
                }
                sh "docker images"
            }
        }

   }
   

}
