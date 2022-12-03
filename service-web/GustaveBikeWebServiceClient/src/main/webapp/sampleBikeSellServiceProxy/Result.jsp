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
        java.lang.String[] getAllBikes15mtemp = sampleBikeSellServiceProxyid.getAllBikes();
if(getAllBikes15mtemp == null){
%>
<%=getAllBikes15mtemp %>
<%
}else{
        String tempreturnp16 = null;
        if(getAllBikes15mtemp != null){
        java.util.List listreturnp16= java.util.Arrays.asList(getAllBikes15mtemp);
        tempreturnp16 = listreturnp16.toString();
        }
        %>
        <%=tempreturnp16%>
        <%
}
break;
case 18:
        gotMethod = true;
        String id_1id=  request.getParameter("id21");
        int id_1idTemp  = Integer.parseInt(id_1id);
        String currency_2id=  request.getParameter("currency23");
            java.lang.String currency_2idTemp = null;
        if(!currency_2id.equals("")){
         currency_2idTemp  = currency_2id;
        }
        String amount_3id=  request.getParameter("amount25");
        long amount_3idTemp  = Long.parseLong(amount_3id);
        boolean buyBike18mtemp = sampleBikeSellServiceProxyid.buyBike(id_1idTemp,currency_2idTemp,amount_3idTemp);
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(buyBike18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 27:
        gotMethod = true;
        String id_4id=  request.getParameter("id40");
        int id_4idTemp  = Integer.parseInt(id_4id);
        fr.uge.projet.bikeWebService.Bike getBike27mtemp = sampleBikeSellServiceProxyid.getBike(id_4idTemp);
if(getBike27mtemp == null){
%>
<%=getBike27mtemp %>
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
if(getBike27mtemp != null){
java.lang.String typename30 = getBike27mtemp.getName();
        String tempResultname30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename30));
        %>
        <%= tempResultname30 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">price:</TD>
<TD>
<%
if(getBike27mtemp != null){
%>
<%=getBike27mtemp.getPrice()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">available:</TD>
<TD>
<%
if(getBike27mtemp != null){
%>
<%=getBike27mtemp.isAvailable()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mechanismType:</TD>
<TD>
<%
if(getBike27mtemp != null){
java.lang.String typemechanismType36 = getBike27mtemp.getMechanismType();
        String tempResultmechanismType36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemechanismType36));
        %>
        <%= tempResultmechanismType36 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getBike27mtemp != null){
%>
<%=getBike27mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
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