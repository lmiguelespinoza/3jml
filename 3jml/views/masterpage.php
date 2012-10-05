<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>:: <?php echo $pagetitle; ?> - Sistema de Pre-venta para Bodegas | 3JML ::</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Sistema de Pre-venta para Bodegas" />
    <meta name="author" content="3JML" />

    <!-- Le styles -->
	<link href="css/normalize.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="">
    <link rel="apple-touch-icon-precomposed" href="">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">

        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="index.php">Proyecto <strong>3JML</strong></a>
          <div class="nav-collapse collapse">
		  
            <ul class="nav">
              <li class="active"><a href="index.php">Inicio</a></li>
              <li><a href="index.php?controlador=cliente">Cliente</a></li>
              <li><a href="index.php?controlador=pedidos">Pedidos</a></li>
              <li><a href="index.php?controlador=promociones">Promociones</a></li>
              <li><a href="index.php?controlador=reportes">Reportes</a></li>              
            </ul>
            
          </div><!--/.nav-collapse -->
          
          
        </div>
      </div>
    </div>

    <div class="container">
	  
      <?php echo $content; ?>

      <hr>

      <footer>
        <p>&copy; 2012 - 3JML.</p>
      </footer>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>

    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>

    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>
    
    <script src="js/functions.js"></script>
    <script src="js/jquery.numeric.js"></script>    
	
    <?php echo $acciones; ?> 
    
  </body>
</html>