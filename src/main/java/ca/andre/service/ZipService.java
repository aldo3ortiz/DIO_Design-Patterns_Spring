package ca.andre.service;

import ca.andre.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
https://ws1.postescanada-canadapost.ca/addresscomplete/interactive/retrieve/v2.11/json.ws?provider=AddressComplete&package=Interactive&service=Retrieve&version=2.11&endpoint=json.ws
 */

//@FeignClient(name = "zip", url = "https://viacep.com.br/ws")
@FeignClient(name = "zip", url = "https://ws1.postescanada-canadapost.ca/addresscomplete/interactive/retrieve/v2.11/json.ws?provider=AddressComplete&package=Interactive&service=Retrieve&version=2.11&endpoint=json.ws")
public interface ZipService {
    @RequestMapping(method = RequestMethod.GET, value = "/{zip}/json/")
    Address searchZip(@PathVariable("zip") String zip);

}
