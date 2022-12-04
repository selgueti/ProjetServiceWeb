<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBikeSellServiceProxyid" scope="session" class="fr.uge.projet.bikeWebService.BikeSellServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBikeSellServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleBikeSellServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleBikeSellServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        fr.uge.projet.bikeWebService.BikeSellService getBikeSellService10mtemp = sampleBikeSellServiceProxyid.getBikeSellService();
if(getBikeSellService10mtemp == null){
%>
<%=getBikeSellService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String id_1id=  request.getParameter("id30");
        int id_1idTemp  = Integer.parseInt(id_1id);
        fr.uge.projet.bikeWebService.Bike getBike15mtemp = sampleBikeSellServiceProxyid.getBike(id_1idTemp);
if(getBike15mtemp == null){
%>
<%=getBike15mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getBike15mtemp != null){
java.lang.String typename18 = getBike15mtemp.getName();
        String tempResultname18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename18));
        %>
        <%= tempResultname18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">price:</TD>
<TD>
<%
if(getBike15mtemp != null){
%>
<%=getBike15mtemp.getPrice()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">available:</TD>
<TD>
<%
if(getBike15mtemp != null){
%>
<%=getBike15mtemp.isAvailable()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mechanismType:</TD>
<TD>
<%
if(getBike15mtemp != null){
java.lang.String typemechanismType24 = getBike15mtemp.getMechanismType();
        String tempResultmechanismType24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemechanismType24));
        %>
        <%= tempResultmechanismType24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">comments:</TD>
<TD>
<%
if(getBike15mtemp != null){
java.lang.String[] typecomments26 = getBike15mtemp.getComments();
        String tempcomments26 = null;
        if(typecomments26 != null){
        java.util.List listcomments26= java.util.Arrays.asList(typecomments26);
        tempcomments26 = listcomments26.toString();
        }
        %>
        <%=tempcomments26%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getBike15mtemp != null){
%>
<%=getBike15mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 32:
        gotMethod = true;
        fr.uge.projet.bikeWebService.Bike[] getAllBikes32mtemp = sampleBikeSellServiceProxyid.getAllBikes();
if(getAllBikes32mtemp == null){
%>
<%=getAllBikes32mtemp %>
<%
}else{
        String tempreturnp33 = null;
        if(getAllBikes32mtemp != null){
        java.util.List listreturnp33= java.util.Arrays.asList(getAllBikes32mtemp);
        tempreturnp33 = listreturnp33.toString();
        }
        %>
        <%=tempreturnp33%>
        <%
}
break;
case 35:
        gotMethod = true;
        String id_2id=  request.getParameter("id38");
        int id_2idTemp  = Integer.parseInt(id_2id);
        String currency_3id=  request.getParameter("currency40");
            java.lang.String currency_3idTemp = null;
        if(!currency_3id.equals("")){
         currency_3idTemp  = currency_3id;
        }
        String amount_4id=  request.getParameter("amount42");
        long amount_4idTemp  = Long.parseLong(amount_4id);
        boolean buyBike35mtemp = sampleBikeSellServiceProxyid.buyBike(id_2idTemp,currency_3idTemp,amount_4idTemp);
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(buyBike35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>