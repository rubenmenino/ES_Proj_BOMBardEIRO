pipeline {
    agent any
    stages {
       // stage('git repo & clean') {
         //   steps {
              //  sh "rmdir  /s /q ES_Proj_BOMBardEIRO"
            //    sh "https://github.com/rubenmenino/ES_Proj_BOMBardEIRO.git"
           //     sh "mvn clean -f ES_Proj_BOMBardEIRO"
         //   }
      //  }
        stage('Build') {
            steps {
                sh 'mvn -f esp11/pom.xml -B -DskipTests clean package'
            }
        }
        stage('test') {
            steps {
                sh "mvn test -f ES_Proj_BOMBardEIRO"
            }
        }
        stage('package') {
            steps {
                sh "mvn package -f ES_Proj_BOMBardEIRO"
            }
        }
    }
}
