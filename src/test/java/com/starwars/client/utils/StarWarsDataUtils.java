package com.starwars.client.utils;

public class StarWarsDataUtils {

    public static String jsonStarShipOnePage(){
        return "{\n" +
                "    \"count\": 1, \n" +
                "    \"next\": null, \n" +
                "    \"previous\": null, \n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"name\": \"CR90 corvette\", \n" +
                "            \"model\": \"CR90 corvette\", \n" +
                "            \"manufacturer\": \"Corellian Engineering Corporation\", \n" +
                "            \"cost_in_credits\": \"3500000\", \n" +
                "            \"length\": \"150\", \n" +
                "            \"max_atmosphering_speed\": \"950\", \n" +
                "            \"crew\": \"30-165\", \n" +
                "            \"passengers\": \"600\", \n" +
                "            \"cargo_capacity\": \"3000000\", \n" +
                "            \"consumables\": \"1 year\", \n" +
                "            \"hyperdrive_rating\": \"2.0\", \n" +
                "            \"MGLT\": \"60\", \n" +
                "            \"starship_class\": \"corvette\", \n" +
                "            \"pilots\": [], \n" +
                "            \"films\": [\n" +
                "                \"http://swapi.dev/api/films/1/\", \n" +
                "                \"http://swapi.dev/api/films/3/\", \n" +
                "                \"http://swapi.dev/api/films/6/\"\n" +
                "            ], \n" +
                "            \"created\": \"2014-12-10T14:20:33.369000Z\", \n" +
                "            \"edited\": \"2014-12-20T21:23:49.867000Z\", \n" +
                "            \"url\": \"http://swapi.dev/api/starships/2/\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public static String jsonStarShipNextPage(){

        return "{\n" +
                "    \"count\": 36, \n" +
                "    \"next\": \"http://swapi.dev/api/starships/?page=2\", \n" +
                "    \"previous\": null, \n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"name\": \"CR90 corvette\", \n" +
                "            \"model\": \"CR90 corvette\", \n" +
                "            \"manufacturer\": \"Corellian Engineering Corporation\", \n" +
                "            \"cost_in_credits\": \"3500000\", \n" +
                "            \"length\": \"150\", \n" +
                "            \"max_atmosphering_speed\": \"950\", \n" +
                "            \"crew\": \"30-165\", \n" +
                "            \"passengers\": \"600\", \n" +
                "            \"cargo_capacity\": \"3000000\", \n" +
                "            \"consumables\": \"1 year\", \n" +
                "            \"hyperdrive_rating\": \"2.0\", \n" +
                "            \"MGLT\": \"60\", \n" +
                "            \"starship_class\": \"corvette\", \n" +
                "            \"pilots\": [], \n" +
                "            \"films\": [\n" +
                "                \"http://swapi.dev/api/films/1/\", \n" +
                "                \"http://swapi.dev/api/films/3/\", \n" +
                "                \"http://swapi.dev/api/films/6/\"\n" +
                "            ], \n" +
                "            \"created\": \"2014-12-10T14:20:33.369000Z\", \n" +
                "            \"edited\": \"2014-12-20T21:23:49.867000Z\", \n" +
                "            \"url\": \"http://swapi.dev/api/starships/2/\"\n" +
                "        } ] "+
                "} ";
    }


    public static String jsonFilmsNextPage(){

        return "{\n" +
                "    \"count\": 6, \n" +
                "    \"next\": \"http://swapi.dev/api/people/1/\", \n" +
                "    \"previous\": null, \n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"title\": \"A New Hope\", \n" +
                "            \"episode_id\": 4, \n" +
                "            \"opening_crawl\": \"It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save her\\r\\npeople and restore\\r\\nfreedom to the galaxy....\", \n" +
                "            \"director\": \"George Lucas\", \n" +
                "            \"producer\": \"Gary Kurtz, Rick McCallum\", \n" +
                "            \"release_date\": \"1977-05-25\", \n" +
                "            \"characters\": [\n" +
                "                \"http://swapi.dev/api/people/1/\", \n" +
                "                \"http://swapi.dev/api/people/2/\", \n" +
                "                \"http://swapi.dev/api/people/3/\", \n" +
                "                \"http://swapi.dev/api/people/4/\", \n" +
                "                \"http://swapi.dev/api/people/5/\", \n" +
                "                \"http://swapi.dev/api/people/6/\", \n" +
                "                \"http://swapi.dev/api/people/7/\", \n" +
                "                \"http://swapi.dev/api/people/8/\", \n" +
                "                \"http://swapi.dev/api/people/9/\", \n" +
                "                \"http://swapi.dev/api/people/10/\", \n" +
                "                \"http://swapi.dev/api/people/12/\", \n" +
                "                \"http://swapi.dev/api/people/13/\", \n" +
                "                \"http://swapi.dev/api/people/14/\", \n" +
                "                \"http://swapi.dev/api/people/15/\", \n" +
                "                \"http://swapi.dev/api/people/16/\", \n" +
                "                \"http://swapi.dev/api/people/18/\", \n" +
                "                \"http://swapi.dev/api/people/19/\", \n" +
                "                \"http://swapi.dev/api/people/81/\"\n" +
                "            ], \n" +
                "            \"planets\": [\n" +
                "                \"http://swapi.dev/api/planets/1/\", \n" +
                "                \"http://swapi.dev/api/planets/2/\", \n" +
                "                \"http://swapi.dev/api/planets/3/\"\n" +
                "            ], \n" +
                "            \"starships\": [\n" +
                "                \"http://swapi.dev/api/starships/2/\", \n" +
                "                \"http://swapi.dev/api/starships/3/\", \n" +
                "                \"http://swapi.dev/api/starships/5/\", \n" +
                "                \"http://swapi.dev/api/starships/9/\", \n" +
                "                \"http://swapi.dev/api/starships/10/\", \n" +
                "                \"http://swapi.dev/api/starships/11/\", \n" +
                "                \"http://swapi.dev/api/starships/12/\", \n" +
                "                \"http://swapi.dev/api/starships/13/\"\n" +
                "            ], \n" +
                "            \"vehicles\": [\n" +
                "                \"http://swapi.dev/api/vehicles/4/\", \n" +
                "                \"http://swapi.dev/api/vehicles/6/\", \n" +
                "                \"http://swapi.dev/api/vehicles/7/\", \n" +
                "                \"http://swapi.dev/api/vehicles/8/\"\n" +
                "            ], \n" +
                "            \"species\": [\n" +
                "                \"http://swapi.dev/api/species/1/\", \n" +
                "                \"http://swapi.dev/api/species/2/\", \n" +
                "                \"http://swapi.dev/api/species/3/\", \n" +
                "                \"http://swapi.dev/api/species/4/\", \n" +
                "                \"http://swapi.dev/api/species/5/\"\n" +
                "            ], \n" +
                "            \"created\": \"2014-12-10T14:23:31.880000Z\", \n" +
                "            \"edited\": \"2014-12-20T19:49:45.256000Z\", \n" +
                "            \"url\": \"http://swapi.dev/api/films/1/\"\n" +
                "        }] "+
                "}         ";
    }

    public static String jsonFilmsOnePage(){

        return "{\n" +
                "    \"count\": 6, \n" +
                "    \"next\": null, \n" +
                "    \"previous\": null, \n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"title\": \"A New Hope\", \n" +
                "            \"episode_id\": 4, \n" +
                "            \"opening_crawl\": \"It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save her\\r\\npeople and restore\\r\\nfreedom to the galaxy....\", \n" +
                "            \"director\": \"George Lucas\", \n" +
                "            \"producer\": \"Gary Kurtz, Rick McCallum\", \n" +
                "            \"release_date\": \"1977-05-25\", \n" +
                "            \"characters\": [\n" +
                "                \"http://swapi.dev/api/people/1/\", \n" +
                "                \"http://swapi.dev/api/people/2/\", \n" +
                "                \"http://swapi.dev/api/people/3/\", \n" +
                "                \"http://swapi.dev/api/people/4/\", \n" +
                "                \"http://swapi.dev/api/people/5/\", \n" +
                "                \"http://swapi.dev/api/people/6/\", \n" +
                "                \"http://swapi.dev/api/people/7/\", \n" +
                "                \"http://swapi.dev/api/people/8/\", \n" +
                "                \"http://swapi.dev/api/people/9/\", \n" +
                "                \"http://swapi.dev/api/people/10/\", \n" +
                "                \"http://swapi.dev/api/people/12/\", \n" +
                "                \"http://swapi.dev/api/people/13/\", \n" +
                "                \"http://swapi.dev/api/people/14/\", \n" +
                "                \"http://swapi.dev/api/people/15/\", \n" +
                "                \"http://swapi.dev/api/people/16/\", \n" +
                "                \"http://swapi.dev/api/people/18/\", \n" +
                "                \"http://swapi.dev/api/people/19/\", \n" +
                "                \"http://swapi.dev/api/people/81/\"\n" +
                "            ], \n" +
                "            \"planets\": [\n" +
                "                \"http://swapi.dev/api/planets/1/\", \n" +
                "                \"http://swapi.dev/api/planets/2/\", \n" +
                "                \"http://swapi.dev/api/planets/3/\"\n" +
                "            ], \n" +
                "            \"starships\": [\n" +
                "                \"http://swapi.dev/api/starships/2/\", \n" +
                "                \"http://swapi.dev/api/starships/3/\", \n" +
                "                \"http://swapi.dev/api/starships/5/\", \n" +
                "                \"http://swapi.dev/api/starships/9/\", \n" +
                "                \"http://swapi.dev/api/starships/10/\", \n" +
                "                \"http://swapi.dev/api/starships/11/\", \n" +
                "                \"http://swapi.dev/api/starships/12/\", \n" +
                "                \"http://swapi.dev/api/starships/13/\"\n" +
                "            ], \n" +
                "            \"vehicles\": [\n" +
                "                \"http://swapi.dev/api/vehicles/4/\", \n" +
                "                \"http://swapi.dev/api/vehicles/6/\", \n" +
                "                \"http://swapi.dev/api/vehicles/7/\", \n" +
                "                \"http://swapi.dev/api/vehicles/8/\"\n" +
                "            ], \n" +
                "            \"species\": [\n" +
                "                \"http://swapi.dev/api/species/1/\", \n" +
                "                \"http://swapi.dev/api/species/2/\", \n" +
                "                \"http://swapi.dev/api/species/3/\", \n" +
                "                \"http://swapi.dev/api/species/4/\", \n" +
                "                \"http://swapi.dev/api/species/5/\"\n" +
                "            ], \n" +
                "            \"created\": \"2014-12-10T14:23:31.880000Z\", \n" +
                "            \"edited\": \"2014-12-20T19:49:45.256000Z\", \n" +
                "            \"url\": \"http://swapi.dev/api/films/1/\"\n" +
                "        }] "+
                "}         ";
    }
}
