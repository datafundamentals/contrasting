cd ~/work/contrasting
docker build -t contrast/pre_a .
docker images
docker ps
docker run -it -d -p 8121:8942 --name contrasting_a contrast/pre_a
echo "at this point you should be able to see JSON at http://192.168.33.13:8121 from a local browser"