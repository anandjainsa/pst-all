def call()
     {
          sh '''
             groupId=`mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.groupId -q -DforceStdout`
             groupId=`echo $groupId| tr . /`
             artifactId=`mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.artifactId -q -DforceStdout`
             version=`mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout`

                     echo "groupId is: $groupId artifactId is: $artifactId version is: $version"
                     echo "version=$version" >> env.properties

             imagename="${artifactId}-$version-${BUILD_ID}"
                  '''
 }
