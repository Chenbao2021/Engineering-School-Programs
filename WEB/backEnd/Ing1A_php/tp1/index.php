<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>


    <?php
        $text=file_get_contents('eleves.json');
        $tab=json_decode($text);
        $newTab=[];


        for($i=0;$i < count($tab);$i++){
            $newTab[$i]["nom"]=$tab[$i]->{'name'} ." ". $tab[$i]->{'firstName'};
            $newTab[$i]["moyenne"]=array_sum($tab[$i]->{'grades'})/count($tab[$i]->{'grades'});
            $newTab[$i]["message"]=getMessage($newTab[$i]["moyenne"]);
        }

        usort($newTab,'compareMeans');
            #On donne la fonction de comparaison en deuxième paramètre.

        for($i=0;$i < count($tab);$i++){
            echo $newTab[$i]["moyenne"]."  ";
        }
            #On affiche les moyens pour vérifier .
    ?>

    <?php
        function getMessage($moyenne)
        {
          if ($moyenne < 10) {
            return 'Redoublement';
          }
          if ($moyenne >= 16) {
            return 'Mention très bien';
          }
          if ($moyenne >= 14) {
            return 'Mention bien';
          }
          if ($moyenne >= 12) {
            return 'Mention assez bien';
          }
          return 'Passage';
        }
        
        function compareMeans($eleve1, $eleve2)
        {
          if ($eleve1['moyenne'] === $eleve2['moyenne']) {
            return 0;
          }
          return ($eleve1['moyenne'] < $eleve2['moyenne']) ? -1 : 1;
        }

    ?>
</body>
</html>
