<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
	
</script>
  </head>
  <body>
      <header id="header">
    <tiles:insertAttribute name="header" />
  </header>

  <div>
    <tiles:insertAttribute name="body" />
  </div>
      <footer id="footer">
      <tiles:insertAttribute name="footer" />
    </footer>

  </body>
</html>