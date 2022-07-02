pipeline {
    agent {
        node {
            label 'ubuntu-2004'
        }
       
    }
     tools {
            maven 'maven'
        }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package -P cloud-gcp'
            }
        }
    }
}
