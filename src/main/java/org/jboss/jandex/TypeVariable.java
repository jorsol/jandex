/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.jandex;

/**
 * @author Jason T. Greene
 */
public class TypeVariable extends Type {
    private String name;
    private Type[] bounds;

    TypeVariable(String name) {
        this(name, EMPTY_ARRAY);

    }

    TypeVariable(String name, Type[] bounds) {
        super(bounds.length > 0 ? bounds[0].name() : DotName.OBJECT_NAME);
        this.name = name;
        this.bounds = bounds;
    }

    public String identifier() {
        return name;
    }

    public Type[] bounds() {
        return bounds;
    }

    @Override
    public Kind kind() {
        return Kind.TYPE_VARIABLE;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);

        // FIXME - revist this logic
        if (bounds.length > 0 && bounds[0].name() != DotName.OBJECT_NAME) {
            builder.append(" extends ").append(bounds[0]);

            for (int i = 1; i < bounds.length; i++) {
                builder.append(" & ").append(bounds[i]);
            }
        }

        return builder.toString();
    }
}
