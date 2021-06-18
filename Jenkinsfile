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
            python_image = ''
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

        stage("Publish python_image to RegistryVM"){
                    steps{
                        script{
                            python_image = docker.build("esp11/python_image", "./Data")
                            docker.withRegistry("http://192.168.160.48:5000") {
                                python_image.push();
                            }
                        }
                        sh "docker images"
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

        stage("Publish react_image to RegistryVM"){
            steps{
                script{
                    react_image = docker.build("esp11/react_image", "./react-admin-dashboard")
                    docker.withRegistry("http://192.168.160.48:5000") {
                        react_image.push();
                    }
                }
                sh "docker images"
            }
        }


        stage('Deploying esp11 in PlayGroundVM ') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'esp11bombeiros', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                            script {
                                remote.user = USERNAME
                                remote.password = PASSWORD
                                remote.allowAnyHosts = true
                            }
                            sshCommand remote: remote, command: "docker pull 192.168.160.48:5000/esp11/bombeiros_image"
                            sshCommand remote: remote, command: "docker create -p 11001:8091 --name esp11_bombeiros 192.168.160.48:5000/esp11/bombeiros_image"
                            sshCommand remote: remote, command: "docker start esp11_bombeiros"
                        }
                    }
                }


   }
   

}
