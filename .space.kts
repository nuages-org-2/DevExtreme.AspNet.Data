job("Deploy Nuages.Authentication"){
    container("mcr.microsoft.com/dotnet/sdk:5.0"){
        env["FEED_URL"] = "https://nuget.pkg.jetbrains.space/nuages/p/nuages/nuget/v3/index.json"
        shellScript {
            content = """
                echo "BUILD nuget package"
                dotnet build net/DevExtreme.AspNet.Data/DevExtreme.AspNet.Data.csproj -c release                 
                if [ $? -eq 0 ]; then

                    if [ $? -eq 0 ]; then
                        echo Publish NuGet package...
                        chmod +x publish.sh
                        ./publish.sh
                    else
                    	exit $?
                    fi
                else
                  	exit $?
                fi
            """
        }
    }
}
