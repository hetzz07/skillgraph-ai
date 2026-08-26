package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.dto.Edge;
import com.skillgraph.dto.Node;
import com.skillgraph.dto.SkillGraphResponse;

@Service
public class SkillGraphService {

    public SkillGraphResponse buildGraph(List<String> skills) {

        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        int id = 1;

        for (String skill : skills) {

            nodes.add(new Node(id, skill));

            if (id > 1) {
                edges.add(new Edge(id - 1, id));
            }

            id++;
        }

        return new SkillGraphResponse(nodes, edges);
    }

}