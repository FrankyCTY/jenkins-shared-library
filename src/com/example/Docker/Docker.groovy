#!/usr/bin/env groovy
package com.example

// Implements Serializable so that state can be kept even pipeline is pause etc.
class Docker implements Serializable {
    // Make Jenkins pipeline syntax available
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
            script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
}