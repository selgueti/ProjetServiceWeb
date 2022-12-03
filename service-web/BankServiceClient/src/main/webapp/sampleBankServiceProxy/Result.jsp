<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBankServiceProxyid" scope="session" class="fr.uge.projet.bank.BankServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBankServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleBankServiceProxyid.getEndpoint();
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
        sampleBankServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        fr.uge.projet.bank.BankService getBankService10mtemp = sampleBankServiceProxyid.getBankService();
if(getBankService10mtemp == null){
%>
<%=getBankService10mtemp %>
<%
}else{
        if(getBankService10mtemp!= null){
        String tempreturnp11 = getBankService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String id_1id=  request.getParameter("id16");
        int id_1idTemp  = Integer.parseInt(id_1id);
        String currency_2id=  request.getParameter("currency18");
            java.lang.String currency_2idTemp = null;
        if(!currency_2id.equals("")){
         currency_2idTemp  = currency_2id;
        }
        String amount_3id=  request.getParameter("amount20");
        long amount_3idTemp  = Long.parseLong(amount_3id);
        boolean checkAvailablebalanceF13mtemp = sampleBankServiceProxyid.checkAvailablebalanceF(id_1idTemp,currency_2idTemp,amount_3idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(checkAvailablebalanceF13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 22:
        gotMethod = true;
        String id_4id=  request.getParameter("id25");
        int id_4idTemp  = Integer.parseInt(id_4id);
        String currency_5id=  request.getParameter("currency27");
            java.lang.String currency_5idTemp = null;
        if(!currency_5id.equals("")){
         currency_5idTemp  = currency_5id;
        }
        String amount_6id=  request.getParameter("amount29");
        long amount_6idTemp  = Long.parseLong(amount_6id);
        boolean checkAvailableBalance22mtemp = sampleBankServiceProxyid.checkAvailableBalance(id_4idTemp,currency_5idTemp,amount_6idTemp);
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(checkAvailableBalance22mtemp));
        %>
        <%= tempResultreturnp23 %>
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