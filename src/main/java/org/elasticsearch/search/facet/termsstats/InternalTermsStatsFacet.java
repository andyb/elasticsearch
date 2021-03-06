/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.facet.termsstats;

import org.elasticsearch.search.facet.Facet;
import org.elasticsearch.search.facet.InternalFacet;
import org.elasticsearch.search.facet.termsstats.doubles.InternalTermsStatsDoubleFacet;
import org.elasticsearch.search.facet.termsstats.longs.InternalTermsStatsLongFacet;
import org.elasticsearch.search.facet.termsstats.strings.InternalTermsStatsStringFacet;

import java.util.List;

public abstract class InternalTermsStatsFacet implements TermsStatsFacet, InternalFacet {

    public static void registerStreams() {
        InternalTermsStatsStringFacet.registerStream();
        InternalTermsStatsLongFacet.registerStream();
        InternalTermsStatsDoubleFacet.registerStream();
    }

    public abstract Facet reduce(String name, List<Facet> facets);
}