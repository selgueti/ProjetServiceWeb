<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleChangeServiceProxyid" scope="session" class="fr.uge.projet.change.ChangeServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleChangeServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleChangeServiceProxyid.getEndpoint();
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
        sampleChangeServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        fr.uge.projet.change.ChangeService getChangeService10mtemp = sampleChangeServiceProxyid.getChangeService();
if(getChangeService10mtemp == null){
%>
<%=getChangeService10mtemp %>
<%
}else{
        if(getChangeService10mtemp!= null){
        String tempreturnp11 = getChangeService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String currencySrc_1id=  request.getParameter("currencySrc16");
            java.lang.String currencySrc_1idTemp = null;
        if(!currencySrc_1id.equals("")){
         currencySrc_1idTemp  = currencySrc_1id;
        }
        String currencyDest_2id=  request.getParameter("currencyDest18");
            java.lang.String currencyDest_2idTemp = null;
        if(!currencyDest_2id.equals("")){
         currencyDest_2idTemp  = currencyDest_2id;
        }
        String amount_3id=  request.getParameter("amount20");
        long amount_3idTemp  = Long.parseLong(amount_3id);
        long change13mtemp = sampleChangeServiceProxyid.change(currencySrc_1idTemp,currencyDest_2idTemp,amount_3idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(change13mtemp));
        %>
        <%= tempResultreturnp14 %>
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