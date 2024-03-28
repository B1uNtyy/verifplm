/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

    private String json;
    private List<Map<String, Object>> MaClasseDynamique;
    private boolean received;
    private boolean proceed;
    private List<String> RegleOff;
    private List<String> RegleParent;

    public JsonToJava() {
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public boolean getReceived() {
        return received;
    }

    public List<Map<String, Object>> getMaclassedynamique() {
        return MaClasseDynamique;
    }

    public boolean getProceed() {
        return proceed;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public void setProceed(boolean proceed) {
        this.proceed = proceed;
    }

    public void setRegleOff(List<String> RegleOff) {
        this.RegleOff = RegleOff;
    }

    public void setRegleParent(List<String> RegleParent){
        this.RegleParent=RegleParent;
    }

    public List<String> getRegleParent() {
        return RegleParent;
    }

    public void addRegleOff(String element) {
        RegleOff.add(element);
    }

    public List<String> getRegleOff() {
        return RegleOff;
    }

    public void MapJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir la chaîne JSON en un objet Map
            Map<String, Object> jsonData = objectMapper.readValue(json, Map.class);

            // Initialiser la liste dynamique si nécessaire
            if (MaClasseDynamique == null) {
                MaClasseDynamique = new ArrayList<>();
            }

            // Vérifier si la clé "Components" existe dans l'objet JSON
            if (jsonData.containsKey("Components")) {
                // Récupérer la liste imbriquée à partir de la clé "Components"
                List<Map<String, Object>> componentsList = (List<Map<String, Object>>) jsonData.get("Components");

                // Ajouter la liste de composants à la liste dynamique
                MaClasseDynamique.addAll(componentsList);

            } else {
                System.err.println("La clé 'Components' n'existe pas dans l'objet JSON.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer l'exception selon les besoins de votre application
        }
    }

}
