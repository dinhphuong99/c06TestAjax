package com.cg.model;


import com.cg.model.dto.LocationRegionDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location_regions")
@Accessors(chain = true)
public class LocationRegion {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String provinceId;
    private String provinceName;

    private String districtId;
    private String districtName;

    private String wardId;
    private String wardName;


    @OneToMany(mappedBy = "locationRegion", fetch = FetchType.EAGER)
    private Set<User> users;


    @Override
    public String toString() {
        return "LocationRegion{" +
                "id=" + id +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", districtId='" + districtId + '\'' +
                ", districtName='" + districtName + '\'' +
                ", wardId='" + wardId + '\'' +
                ", wardName='" + wardName + '\'' +
                '}';
    }

    public LocationRegionDTO toLocationRegionDTO() {
        return new LocationRegionDTO()
                .setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName);
    }
}
