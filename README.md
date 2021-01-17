# Quasar-Challenge
Challenge Mercado Libre

Description

Se pide construir una API que cumpla con los siguientes requerimientos:

Request que debe responder:

HEALTH

curl http://challengequasar-env.eba-2iemytnc.us-east-2.elasticbeanstalk.com/topsecret/status

Respuesta

Debe responder a las siguientes APIS:

1)http://challengequasar-env.eba-2iemytnc.us-east-2.elasticbeanstalk.com/topsecret/status. (GET)
2)http://challengequasar-env.eba-2iemytnc.us-east-2.elasticbeanstalk.com/topsecret.        (POST)

    {"satellites":
    [


    {"name":"skywalker",
        "distance":115.5,
        "message":["","es" , "", "", "secreto"]
        },
    {"name":"kenobi",
        "distance":100.0,
        "message":["este","","", "mensaje",""]},

        {"name":"sato",
        "distance":142.7,
        "message":["este", "" ,"un", "",""]}
    ]
    }
    
   Reponse JSON
   Si e sposible su calculo de lo contrario response 404 NOT FOUND 
   
    {
    "position": {
        "x": -487.28591304435724,
        "y": 1557.0142282661438
    },
    "message": "este es un mensaje secreto "
}
    
3) http://challengequasar-env.eba-2iemytnc.us-east-2.elasticbeanstalk.com/topsecret_split/{satellite_name}.  (POST)

      {
       "distance":142.7,
          "message":["este", "" ,"un", "",""]}
      }
    
4) http://challengequasar-env.eba-2iemytnc.us-east-2.elasticbeanstalk.com/topsecret_split/.                  (GET)

  Solo si tiene la información de los 3 satellites de lo contrario response 404 NOT FOUND 
  
  Reponse JSON
  
    {
      "position": {
          "x": -487.28591304435724,
          "y": 1557.0142282661438
      },
      "message": "este es un mensaje secreto "
  }
  
  Mejoras:
  
  a. Implementar un balanceador
  b. Implementar un grupo de autoescalamiento varias zonas dependiendo la carga
  c. CloudWath para monitorear los logs
  

