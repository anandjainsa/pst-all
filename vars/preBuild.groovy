def call(MVN_RELEASE_VERSION)
     {
          sh '''
		git checkout -b develop
		if [ ! -z $MVN_RELEASE_VERSION ]
				then
		git checkout -b release/${MVN_RELEASE_VERSION} develop
		 fi

                  '''
 }
