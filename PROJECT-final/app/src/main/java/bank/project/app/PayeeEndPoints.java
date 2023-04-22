package bank.project.app;

import bank.project.app.soap.ListPayeeRequest;
import bank.project.app.soap.ListPayeeResponse;
import bank.project.app.soap.ServiceStatus;
import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Payee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class PayeeEndPoints {

        private static final String url="http://soap.app.project.bank";
        private Logger logger= LoggerFactory.getLogger(PayeeEndPoints.class);

        @Autowired
        private BankService bankService;


        @PayloadRoot(namespace = url,localPart = "listPayeeRequest")
        @ResponsePayload
        public ListPayeeResponse listPayeeResponse(@RequestPayload ListPayeeRequest listPayeeRequest){
            ListPayeeResponse response=new ListPayeeResponse();
            ServiceStatus serviceStatus=new ServiceStatus();

            //create list for actual payee pojo
            List<Payee> payeeList =bankService.listPayee(listPayeeRequest.getUsername());// pojo objects

            //create list for soap(xml) payee pojo
            List<bank.project.app.soap.Payee> listxmlpayee=new ArrayList<>();// xml list of objects as of its empty

            Iterator<Payee> iterator= payeeList.iterator();
            while(iterator.hasNext()){
                bank.project.app.soap.Payee payee = new bank.project.app.soap.Payee();// XSD POJO
                //copy xsd objects to actual pojo
                BeanUtils.copyProperties(iterator.next(),payee);
                listxmlpayee.add(payee);

            }
            response.getPayee().addAll(listxmlpayee);
            logger.info(response.toString());
            return response;

        }

}
