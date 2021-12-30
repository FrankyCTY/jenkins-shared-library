#!/usr/bin/env groovy

def call(String imageName) {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh "docker push $imageName"
    }
}