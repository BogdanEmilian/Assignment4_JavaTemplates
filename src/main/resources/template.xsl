<?xml version="1.0" encoding="ISO-8859-1"?>

	<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
		<xsl:template match="/queue">
		<html>
			<head>
				<title>Reading queue</title>
			</head>
			<body>
				<ul>
					<xsl:for-each select="./task">
						<li>
							<strong><xsl:value-of select="./title" /></strong>
							<br/>
							<em><xsl:value-of select="./description"/></em>
							<br/>
							<xsl:value-of select="./dueDate"/>
							<br/>
							<strong><xsl:value-of select="./status"/></strong>
							<br/>
							<a>
								<xsl:attribute name="href">
									<xsl:value-of select="./uri" />
								</xsl:attribute>
								<xsl:value-of select="./uri" />
							</a>
							<br/>
							<a>
								<xsl:attribute name="id">
									<xsl:value-of select="./uri" />
								</xsl:attribute>
								<xsl:value-of select="./uri" />
							</a>
							<br/>
							<a>
								<xsl:attribute name="comment">
									<xsl:value-of select="./uri" />
								</xsl:attribute>
								<xsl:value-of select="./uri" />
							</a>
							<br/>
						</li>
					</xsl:for-each>
				</ul>
			</body>
		</html>
		</xsl:template>
	</xsl:stylesheet>