/*
 * Copyright 2012 uaiHebert Solucoes em Informatica
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package br.gov.frameworkdemoiselle.prodepa.queryfilter.app.filter;

import java.util.Date;

import br.gov.frameworkdemoiselle.prodepa.queryfilter.annotations.And;
import br.gov.frameworkdemoiselle.prodepa.queryfilter.stereotype.QueryFilter;

@QueryFilter
public class AddressFilter {

    @And
    private Integer id;

    private String streetName;
    private Long houseNumber;
    private Boolean isOld;
    private Boolean isYellow;

    private Date buildingDate;

    public AddressFilter() {

    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getStreetName() {
      return streetName;
    }

    public void setStreetName(String streetName) {
      this.streetName = streetName;
    }

    public Long getHouseNumber() {
      return houseNumber;
    }

    public void setHouseNumber(Long houseNumber) {
      this.houseNumber = houseNumber;
    }

    public Boolean getIsOld() {
      return isOld;
    }

    public void setIsOld(Boolean isOld) {
      this.isOld = isOld;
    }

    public Boolean getIsYellow() {
      return isYellow;
    }

    public void setIsYellow(Boolean isYellow) {
      this.isYellow = isYellow;
    }

    public Date getBuildingDate() {
      return buildingDate;
    }

    public void setBuildingDate(Date buildingDate) {
      this.buildingDate = buildingDate;
    }

    
}