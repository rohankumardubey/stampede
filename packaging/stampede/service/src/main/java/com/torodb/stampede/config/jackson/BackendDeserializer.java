/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.stampede.config.jackson;

import java.util.function.BiConsumer;

import org.jooq.lambda.tuple.Tuple2;

import com.google.common.collect.ImmutableMap;
import com.torodb.stampede.config.model.backend.Backend;
import com.torodb.stampede.config.model.backend.Pool;

public class BackendDeserializer extends com.torodb.packaging.config.jackson.BackendDeserializer<Backend> {
    
    public BackendDeserializer() {
        super(() -> new Backend(),
                ImmutableMap.<String, Tuple2<Class<?>, BiConsumer<Backend, Object>>>of(
                        "pool", new Tuple2<>(Pool.class, (backend, value) -> backend.setPool((Pool) value))
                )
        );
    }

}