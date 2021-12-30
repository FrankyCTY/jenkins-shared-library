#!/usr/bin/env groovy

def call() {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh'docker build -t <repo domain>/<image name>:<tag> .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh 'docker push <repo domain>/<image name>:<tag>'
    }
}