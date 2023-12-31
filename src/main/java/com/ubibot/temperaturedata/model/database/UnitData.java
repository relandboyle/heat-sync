package com.ubibot.temperaturedata.model.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity(name = "unit")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnitData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "unit_id")
    private String unitId;

    @Column(name = "unit_number")
    private String unitNumber;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "full_unit")
    private String fullUnit;

    @Column(name = "building_id")
    private String buildingId;

    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    @Column(name = "sensors")
    private List<SensorData> sensors;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "building")
    private BuildingData building;
}
