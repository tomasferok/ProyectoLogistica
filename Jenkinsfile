pipeline {
  agent {
    node {
      label 'ubuntu-2004'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
        googleStorageUpload(pattern: '/tmp/workspace/ectoLogistica_feature_despliegue/target/LogisticaApp-0.0.1-SNAPSHOT.jar', bucket: 'gs://clawtech-logistica-proyecto-jenkins-artifacts/$JOB_NAME/$BUILD_NUMBER', credentialsId: 'gcloud')
      }
    }

    stage('Test') {
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }

      }
      steps {
        sh 'mvn test'
      }
    }

    stage('Deliver') {
      steps {
        sh 'mvn -B -DskipTests clean package -P cloud-gcp'
      }
    }

  }
  tools {
    maven 'maven'
  }
}