/*
 * Copyright 2015 Samuel Franklyn <sfranklyn@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package galileonews.ejb.dao;

import galileonews.jpa.Attachment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Samuel Franklyn <sfranklyn@gmail.com>
 */
@Stateless
public class AttachmentDaoBean {

    @PersistenceContext
    private EntityManager em;

    public void insert(Attachment attachment) {
        em.persist(attachment);
        em.flush();
    }

    public void delete(Integer attachmentId) {
        Attachment attachment = em.find(Attachment.class, attachmentId);
        em.remove(attachment);
        em.flush();
    }

    public void update(Attachment attachment) {
        em.merge(attachment);
        em.flush();
    }

    public Attachment find(Integer attachmentId) {
        return em.find(Attachment.class, attachmentId);
    }
    
}
