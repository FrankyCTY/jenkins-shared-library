#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    // Passing this function's context to Docker constructor for pipeline syntax
    def docker = new Docker(this);
    return docker.buildDockerImage(imageName)
}