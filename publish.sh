echo "Configure credentials"
dotnet nuget add source $FEED_URL -n space -u "%JB_SPACE_CLIENT_ID%" -p "%JB_SPACE_CLIENT_SECRET%" --store-password-in-clear-text
VERSION=1.0.$JB_SPACE_EXECUTION_NUMBER

echo "PACK nuget package"
dotnet pack net/DevExtreme.AspNet.Data/DevExtreme.AspNet.Data.csproj -c release -p:PackageVersion=$VERSION -o ./
echo "PUSH nuget package"
dotnet nuget push DevExtreme.AspNet.Data.$VERSION.nupkg -s space
